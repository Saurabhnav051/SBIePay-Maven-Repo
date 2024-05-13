package com.epay.encdata.controller;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.MultiValueMap;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.view.RedirectView;
import com.epay.encdata.config.AES256Bit;
import com.epay.encdata.entity.AggStatusQueryAPIRequestBean;
import com.epay.encdata.entity.AggregatorHosted;
import com.epay.encdata.entity.QueryApiEntity;
import com.epay.encdata.entity.QueryRequest;
import com.epay.encdata.entity.RefundRequest;
import com.epay.encdata.entity.StatusQuery;
import com.epay.encdata.util.AESEncryptDecrypt;
import com.epay.encdata.util.GetMekKey;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.springframework.util.LinkedMultiValueMap;

//import com.epay.encdata.entity.Adddata;

@RestController
public class RedirectUrl {	
	
	@Autowired
	MyComponent myComponent;
	
	
	@Autowired
	MyComponent livemyComponent;
	
	@Autowired
	GetMekKey mekKey;
	
	private final ObjectMapper objectMapper = new ObjectMapper();

	@PostMapping("/PaymentCheckout")
	public RedirectView redirectcallredirect(HttpServletRequest req) {
	
		String meKey="";
		String encryptedInputValue ="";
		String ordernumber=req.getParameter("MerchantOrderNo");
		String orderAmount=req.getParameter("orderAmount");
		
		try {
		 	 String value=myComponent.getMerchantId()+"|"+myComponent.getOperatingMode()+"|"+myComponent.getMerchantCountry()+"|"+myComponent.getMerchantCurrency()+"|"+orderAmount+"|"+myComponent.getOtherDetails()+"|"+myComponent.getSuccessUrl()+"|"+myComponent.getFailUrl()+"|"+myComponent.getAggregatorId()+"|"+ordernumber+"|"+ordernumber+"|"+myComponent.getPaymode()+"|"+myComponent.getAccessMedium()+"|"+myComponent.getTransactionSource();
		 	 meKey= mekKey.getMeK(myComponent.getMerchantId(),myComponent.getKkValue(),myComponent.getMkValue());
		 	 encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);	
		 	 
		}catch(Exception e ) {	
			 e.printStackTrace();
		}
		
		AggregatorHosted aggregatorHosted=new AggregatorHosted();
		aggregatorHosted.setEncryptTrans(encryptedInputValue);
		aggregatorHosted.setEncryptpaymentDetails("");
		aggregatorHosted.setMerchIdVal(myComponent.getMerchantId());
		aggregatorHosted.setEncryptbillingDetails("");
		aggregatorHosted.setEncryptshippingDetais("");
		aggregatorHosted.setHiddenMerchantOrderNo(ordernumber);
		
		try {
				return new RedirectView(myComponent.getTransactionUrl()+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction");
		} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
		}
		return null;
	}
	
public String TransactionRequest(String MerchantOrderNo,String orderAmount1,String mkValue,String kkValue,String merchentid,String sucessurl,String failurl) {
	
		String meKey="";
		String encryptedInputValue ="";
		String ordernumber=MerchantOrderNo;
		String orderAmount=orderAmount1;
		String mkValuenew=mkValue;
		String kkValuenew=kkValue;
		
		try {

			String value=""+merchentid+"|"+myComponent.getOperatingMode()+"|"+myComponent.getMerchantCountry()+"|"+myComponent.getMerchantCurrency()+"|"+orderAmount+"|"+myComponent.getOtherDetails()+"|"+sucessurl+"|"+failurl+"|"+myComponent.getAggregatorId()+"|"+ordernumber+"|"+ordernumber+"|"+myComponent.getPaymode()+"|"+myComponent.getAccessMedium()+"|"+myComponent.getTransactionSource();
			meKey= mekKey.getMeK(merchentid,kkValuenew,mkValuenew);
			encryptedInputValue = AESEncryptDecrypt.encrypt(value, meKey);
				
		}catch(Exception e ) {
			e.printStackTrace();
		}
		
		AggregatorHosted aggregatorHosted=new AggregatorHosted();
		aggregatorHosted.setEncryptTrans(encryptedInputValue);
		aggregatorHosted.setEncryptpaymentDetails("");
		aggregatorHosted.setMerchIdVal(merchentid);
		aggregatorHosted.setEncryptbillingDetails("");
		aggregatorHosted.setEncryptshippingDetais("");
		aggregatorHosted.setHiddenMerchantOrderNo(ordernumber);
		
	 
		  try {
				return myComponent.getTransactionUrl()+URLEncoder.encode(aggregatorHosted.getEncryptTrans(),"UTF-8")+"&EncryptbillingDetails="+URLEncoder.encode(aggregatorHosted.getEncryptbillingDetails(),"UTF-8")+"&EncryptshippingDetais="+URLEncoder.encode(aggregatorHosted.getEncryptshippingDetais(),"UTF-8")+"&EncryptpaymentDetails="+aggregatorHosted.getEncryptpaymentDetails()+"&merchIdVal="+aggregatorHosted.getMerchIdVal()+"&hiddenMerchantOrderNo="+aggregatorHosted.getHiddenMerchantOrderNo()+"&neftRtgsMobileNumber="+aggregatorHosted.getNeftRtgsMobileNumber()+"&neftRtgsEmailId="+aggregatorHosted.getNeftRtgsEmailId()+"&neftChallanExpDt="+aggregatorHosted.getNeftChallanExpDt()+"&cashCustomerName="+aggregatorHosted.getCashCustomerName()+"&Submit=Proceed Transaction";
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
	
	}
	
//added by saurabh
@PostMapping("/queryAPI")
public String queryApiRequest(@RequestBody QueryRequest request) {
    
	String queryRequest = request.getQueryRequest();
    String aggregatorId = request.getAggregatorId();
    String merchantId = request.getMerchantId();

    String encodedRequest = "queryRequest=" + queryRequest + "&aggregatorId=" + aggregatorId + "&merchantId=" + merchantId;
    
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

    HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);

 
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getapiUrl(), httpEntity, String.class);

    String responseBody = responseEntity.getBody();

    return responseBody;
}

//added by saurabh
//@PostMapping("/transactionMISAPI")
//public String getTransactionMISAPIRequest(@RequestBody QueryRequest request) {
//  
//  String queryRequest = request.getQueryRequest();
//  String aggregatorId = request.getAggregatorId();
//  String merchantId = request.getMerchantId();
//
//  String encodedRequest = "queryRequest=" + queryRequest + "&aggregatorId=" + aggregatorId + "&merchantId=" + merchantId;
//  
//  HttpHeaders headers = new HttpHeaders();
//  headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//
//  HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);
//
//
//  RestTemplate restTemplate = new RestTemplate();
//  ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getTransactionMISAPI(), httpEntity, String.class);
//
//  String responseBody = responseEntity.getBody();
//
//  return responseBody;
//}

//added by saurabh
@PostMapping("/transactionMISAPI")
public String getTransactionMISAPIRequest(@RequestBody String request) {

	String queryRequest = "";
	
	 try {
         JsonNode jsonNode = objectMapper.readTree(request);
         String queryRequestBefore = jsonNode.get("queryRequest").asText();
         
         System.out.println("Query Request: " + queryRequestBefore);
        
         String[] parts = queryRequestBefore.split("\\|");
         if (parts.length != 2) {
             return "Invalid queryRequest format";
         }
         
         
         String date = parts[0];
         String status = parts[1];
         
         System.out.println("Date: " + date);
         System.out.println("Status: " + status);
         
         System.out.println("queryRequestBefore: " + queryRequestBefore);
         
         
         queryRequest = myComponent.getAggregatorId()+"|"+myComponent.getMerchantId()+"|"+myComponent.getOperatingMode() + "|" + myComponent.getMerchantCountry() + "|"
     			+ myComponent.getMerchantCurrency() + "|" + date+"|"+status+"|"+""+"|"+""+"|"+""+"|";
     	
     	System.out.println("queryRequest:  " + queryRequest);

     	String encodedRequest = "queryRequest=" + queryRequest + "&aggregatorId=" + myComponent.getAggregatorId()
    	+ "&merchantId=" + myComponent.getMerchantId();
      
      HttpHeaders headers = new HttpHeaders();
      headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

      HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);


      RestTemplate restTemplate = new RestTemplate();
      ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getTransactionMISAPI(), httpEntity, String.class);

      String responseBody = responseEntity.getBody();

      return responseBody;   
       
     } catch (Exception e) {
         e.printStackTrace();
         return "Error processing the request";
     }
  
}




//@PostMapping("/transactionPayoutAPI")
//public String getTransactionPayoutAPI(@RequestBody QueryRequest request) {
//
//	String queryRequest = request.getQueryRequest();
//	String aggregatorId = request.getAggregatorId();
//	String merchantId = request.getMerchantId();
//	
//	String encodedRequest = "queryRequest=" + queryRequest + "&aggregatorId=" + aggregatorId + "&merchantId=" + merchantId;
//	
//	HttpHeaders headers = new HttpHeaders();
//	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
//	
//	HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);
//	
//	
//	RestTemplate restTemplate = new RestTemplate();
//	ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getTransactionPayoutAPI(), httpEntity, String.class);
//	
//	String responseBody = responseEntity.getBody();
//	
//	return responseBody;
//}

//added by saurabh
@PostMapping("/transactionPayoutAPI")
public String getTransactionPayoutAPI(@RequestBody QueryRequest request) {

	String queryRequest = "";

	String payoutDate = request.getQueryRequest();

	// "DOM|IN|INR|09052023"
	
	queryRequest = myComponent.getOperatingMode() + "|" + myComponent.getMerchantCountry() + "|"
			+ myComponent.getMerchantCurrency() + "|" + payoutDate;
	
	System.out.println("queryRequest:  " + queryRequest);
	
	queryRequest = myComponent.getOperatingMode() + "|" + myComponent.getMerchantCountry() + "|"
			+ myComponent.getMerchantCurrency() + "|" + payoutDate;
	
	System.out.println("queryRequest:  " + queryRequest);

	String encodedRequest = "queryRequest=" + queryRequest + "&aggregatorId=" + myComponent.getAggregatorId()
			+ "&merchantId=" + myComponent.getMerchantId();

	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

	HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getTransactionPayoutAPI(),
			httpEntity, String.class);

	String responseBody = responseEntity.getBody();

	return responseBody;
}



//added by saurabh
@PostMapping("/refundAPI")
public String refundApiRequest(@RequestBody String request) throws Exception {

	String regex = "\"refundRequest\":\"(.*?)\"";
	
//	{
//	    "refundRequest":"Sha1432|8374370451010|01|h7Rwz"
//	}
//
//	{
//	    "refundRequest":"SBIEPAY|1000003|Sha143|8374370451010|01|INR|h7Rwz"
//	}


	Pattern pattern = Pattern.compile(regex);
	Matcher matcher = pattern.matcher(request);
	String extractedSubstring = "";
	if (matcher.find()) {
		String extractedSubstring1 = matcher.group(1);
		extractedSubstring = extractedSubstring1;
		System.out.println("extractedSubstring:" + extractedSubstring1);
	} else {
		System.out.println("Substring not found");
	}

	// Parse refundRequest string
	String[] requestParams = extractedSubstring.split("\\|");
	if (requestParams.length != 4) {
		return "Invalid refund request format";
	}

	// Extract parameters
	String refundRequestId = requestParams[0];
	String referenceNumber = requestParams[1];
	double refundAmount = Double.parseDouble(requestParams[2]);
	String orderNumber = requestParams[3];
	String meKey = "";
	String refundRequest = "";

	String value = myComponent.getAggregatorId() + "|" + myComponent.getMerchantId() + "|" + refundRequestId + "|"
			+ referenceNumber + "|" + refundAmount + "|" + myComponent.getMerchantCurrency() + "|" + orderNumber;
	
	meKey = mekKey.getMeK(myComponent.getMerchantId(), myComponent.getKkValue(), myComponent.getMkValue());
	
	refundRequest = AESEncryptDecrypt.encrypt(value, meKey);

//	System.out.println("value  ::" + value);
//	System.out.println("refundRequest  ::" + refundRequest);
	String encodedRequest = "refundRequest=" + refundRequest + "&aggregatorId=" + myComponent.getAggregatorId()
			+ "&merchantId=" + myComponent.getMerchantId();
	
//	System.out.println("encodedRequest  :" + encodedRequest);
	HttpHeaders headers = new HttpHeaders();
	headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
	HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);

	RestTemplate restTemplate = new RestTemplate();
	ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getRefundApiUrl(), httpEntity,
			String.class);

	String responseBody = responseEntity.getBody();
//	System.out.println("responseBody  :" + responseBody);
	return responseBody;
}


/*
 * @PostMapping("/encQueryAPI") public String encQueryApiRequest(@RequestBody
 * QueryRequest request) throws NullPointerException, Exception {
 * 
 * String queryRequest = request.getQueryRequest(); String aggregatorId =
 * request.getAggregatorId(); String merchantId = request.getMerchantId();
 * 
 * 
 * String meKey="";
 * 
 * 
 * meKey= mekKey.getMeK(myComponent.getMerchantId(),myComponent.getKkValue(),
 * myComponent.getMkValue());
 * 
 * String encryptQueryRequest = AESEncryptDecrypt.encrypt(queryRequest, meKey);
 * 
 * 
 * String encodedRequest = "queryRequest=" + encryptQueryRequest +
 * "&aggregatorId=" + aggregatorId + "&merchantId=" + merchantId;
 * 
 * 
 * 
 * HttpHeaders headers = new HttpHeaders();
 * 
 * 
 * headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
 * 
 * HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);
 * 
 * 
 * RestTemplate restTemplate = new RestTemplate(); ResponseEntity<String>
 * responseEntity = restTemplate.postForEntity(myComponent.getapiUrl(),
 * httpEntity, String.class);
 * 
 * String responseBody = responseEntity.getBody();
 * 
 * return responseBody; }
 */


public static String checksum(String checksumValue, String ChecksumFlag) {
		
		if (ChecksumFlag.equals("SHA256")) {
			return DigestUtils.sha256Hex(checksumValue);
		} else if (ChecksumFlag.equals("SHA512")) {
			return DigestUtils.sha512Hex(checksumValue);
		} else {
			return null;
		}
	}
	
	@GetMapping("/getCheckSum/{data}/{flag}")
	public String getCheckSum(@PathVariable(name = "data") String data,@PathVariable(name = "flag") String flag) {
	String checkSumValue="";
	
	checkSumValue=checksum(data, flag);
	return checkSumValue;
	}
	
	public static String decrypt(String encryptedValue, String key) throws NullPointerException, Exception {
		String decryptedValue = "";
		try {
				SecretKeySpec secretkeyspec=null;
				secretkeyspec = AES256Bit.readKeyBytes(key);
				decryptedValue = AES256Bit.decrypt(encryptedValue, secretkeyspec);
			 
		}  catch (Exception ex) {
			ex.printStackTrace();
		}
		return decryptedValue;
	}
	
	
	public static String encrypt(String decryptedValue,String key)
			throws NullPointerException, Exception {
		String encryptValue = "";
		
		SecretKeySpec secretkeyspec=null;
		secretkeyspec = AES256Bit.readKeyBytes(key);
		encryptValue = AES256Bit.encrypt(decryptedValue, secretkeyspec);
		
		return encryptValue;
		
	}
	
	
	//added by shital sir
	@PostMapping("/statusquery") public ResponseEntity<String> getQueryData(@RequestBody
			  String statusdata) {
			  
			  Gson gobj = new Gson(); 
			  StatusQuery getStatusquery=new StatusQuery();
			  
			  StatusQuery status = gobj.fromJson(statusdata, StatusQuery.class) ;
			 // getStatusquery.setAggregatorId(status.getAggregatorId());
			  getStatusquery.setAmount(status.getAmount());
			  getStatusquery.setAtrn(status.getAtrn());
			  getStatusquery.setMerchantId(status.getMerchantId());
			  getStatusquery.setMerchOrderNo(status.getMerchOrderNo());
			  getStatusquery.setSourceUrl(status.getSourceUrl());
			  AggStatusQueryAPIRequestBean aggStatusQueryAPIRequestBean=new AggStatusQueryAPIRequestBean();
			  
			 
			  aggStatusQueryAPIRequestBean.setReq(status);
			 // String s=aggStatusQueryAPIRequestBean.getReq().toString();
			// AggStatusQueryAPIRequestBean aggStatusQueryAPIReqBean = gobj.fromJson(aggStatusQueryAPIRequestBean.getReq().toString(), AggStatusQueryAPIRequestBean.class);
			 // System.out.println("status"+aggStatusQueryAPIReqBean.toString());
			  System.out.println("status1"+aggStatusQueryAPIRequestBean.toString());
			  JSONObject jsondata = new JSONObject(aggStatusQueryAPIRequestBean); 
			  JSONObject jsonarray=new JSONObject();
			  System.out.println("Bean request"+aggStatusQueryAPIRequestBean.getReq().getAtrn());
				
				String encriptStatusRequest=null;
				JSONObject jsondata1 = new JSONObject(aggStatusQueryAPIRequestBean); 
				try {
					 String  meKey = mekKey.getMeK(myComponent.getMerchantId(), myComponent.getKkValue(), myComponent.getMkValue());
						
					//encriptStatusRequest = AESEncryptDecrypt.encrypt(aggStatusQueryAPIRequestBean.getReq().toString(), meKey);
					 
					 String s=jsondata1.toString();
					 
					 System.out.println("Bean s"+s);
					 encriptStatusRequest = AESEncryptDecrypt.encrypt(jsondata1.toString(), meKey);
						
				} catch (NullPointerException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				System.out.println("encriptStatusRequest"+encriptStatusRequest);				
				//ResponseEntity<String> responseBody=getQueryAPI1("6myPSGR+Jk0xpwRVFQJ9XOFCJuBW+LUmxweFI2Pm2p30j4ez2r0Qv6Cu8g7iZWIRnmm/cWOp6FMdjD7hNgErFej/VEgBFIMXQ+zgmXZmHeLx5Qo5AHyYwgrPDEyjZt2bcTH/MF3Z2he84BEu6dzdKn2Lstksv0LxXEJu8hoe9zONKpqy6TW3vNOYE7nvkyQjLjT2WDORpSGngeDjYWGzfomCVFjoZUTv33bHki3ifI8=","875de8bf3bf03178de993b128be1ef7514d00f3cafcd4564c4854fc1266a5dfe","1000003");
				ResponseEntity<String> responseBody=getQueryAPI1(encriptStatusRequest,checksum(jsondata1.toString(),myComponent.getChecksumMethod()),myComponent.getMerchantId());
				
				System.out.println(responseBody); 
			  return responseBody; 
			  
			  }
	
	
	public String getQueryAPI(String encdata, String cs, String merchantid) {
		QueryApiEntity req = new QueryApiEntity();
		req.setEncData(encdata);
		req.setCs(cs);
		req.setMerchantCode(merchantid);	
		String encodedRequest = "encData=" + encdata + "&cs=" + cs
		+ "&merchantCode=" + myComponent.getMerchantId();

//System.out.println("encodedRequest  :" + encodedRequest);
HttpHeaders headers = new HttpHeaders();
headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
HttpEntity<String> httpEntity = new HttpEntity<>(encodedRequest, headers);

RestTemplate restTemplate = new RestTemplate();
ResponseEntity<String> responseEntity = restTemplate.postForEntity(myComponent.getRefundApiUrl(), httpEntity,
		String.class);



String responseBody = responseEntity.getBody();
return responseBody;
	}
	 
	
	public ResponseEntity<String> getQueryAPI1(String encdata, String cs, String merchantid) {
		QueryApiEntity req = new QueryApiEntity();
		req.setEncData(encdata);
		req.setCs(cs);
		req.setMerchantCode(merchantid);
		RestTemplate restTemplate = new RestTemplate();

		try {

			ResponseEntity<String> response = restTemplate.postForEntity(myComponent.getStatusQueryAPI(), req, String.class);
			return ResponseEntity.ok().body(response.getBody());

		} catch (HttpServerErrorException e) {
			
			String errorMessage = "Server error occurred: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		} catch (Exception e) {
			
			String errorMessage = "An error occurred: " + e.getMessage();
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorMessage);
		}

	}

}

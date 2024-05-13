package com.epay.encdata.service;

import java.util.List;

import com.epay.encdata.entity.MerchantDetailEntity;

public interface MerchantDetail {
	List<MerchantDetailEntity> getAllSftpReconDetails(String merchantid);
}

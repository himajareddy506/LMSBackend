package com.hcl.lms.service;

import java.util.List;

import com.hcl.lms.dto.AddSummaryInfo;

public interface UserBookSummary {
	List<AddSummaryInfo> addSummaryInfo(Integer userId);
}

package cn.kgc.service;

import cn.kgc.pojo.Deal;

import java.util.List;

public interface DealService {

    List<Deal> findDealByAccountId(Integer accountId);

    int saveDeal(double dealIncome,int accountId);
}

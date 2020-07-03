package com.ht.service.businessService.yservice.yImpl;

import com.ht.mapper.businessMapper.YInstallationDispatchMapper;
import com.ht.pojo.Staff;
import com.ht.pojo.YDistributeLeafletss;
import com.ht.service.businessService.yservice.YInstallationDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class YInstallationDispatchServiceImpls implements YInstallationDispatchService {
    @Autowired
    private YInstallationDispatchMapper yinstallationDispatchMapper;


    @Override
    public List<YDistributeLeafletss> getInstallationDispatch(Integer limit, Integer page, String sname, String customerAddress) {
        return yinstallationDispatchMapper.getInstallationDispatch(limit, (page - 1) * limit, sname, customerAddress);
    }

    @Override
    public int getInstallationDispatchs(String sname, String customerAddress) {
        return yinstallationDispatchMapper.getInstallationDispatchs(sname, customerAddress);
    }

    @Override
    public int deleInstallationDispatchs(Integer[] did) {
        return yinstallationDispatchMapper.deleInstallationDispatchs(did);
    }

    @Override
    public List<Staff> getstaff() {
        return yinstallationDispatchMapper.getstaff();
    }

    @Override
    public int insert(YDistributeLeafletss YDistributeLeafletss) {
        return yinstallationDispatchMapper.insert(YDistributeLeafletss);
    }

    @Override
    public int updaInstallationDispatchs(YDistributeLeafletss YDistributeLeafletss) {
        return yinstallationDispatchMapper.updaInstallationDispatchs(YDistributeLeafletss);
    }




}

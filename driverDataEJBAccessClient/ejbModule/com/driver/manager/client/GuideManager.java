package com.driver.manager.client;

import java.util.Date;
import java.util.List;

import javax.ejb.Remote;

import com.driver.entity.client.Guide;


@Remote
public interface GuideManager {
	List<Guide> getDmHuongDanSuDungList(String ten, String duongDan, Date ngayCapNhat);
}

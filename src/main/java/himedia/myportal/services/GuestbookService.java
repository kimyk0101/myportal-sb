package himedia.myportal.services;

import java.util.List;

import himedia.myportal.repositories.vo.GuestbookVo;

public interface GuestbookService {
	public List<GuestbookVo> getMessageList() ;
	public boolean writeMessage(GuestbookVo guestbookVo);
	public boolean deleteMessage(GuestbookVo guestbookVo);
}

package controller;

import java.util.ArrayList;

import model.Session;
import model.dao.LikelistDAO;
import model.dto.LikelistDTO;

public class LikelistController {
	
	public boolean addList(){
		LikelistDAO likeDao = new LikelistDAO();
		return likeDao.addList();
	}
	
	public ArrayList<LikelistDTO> getLikeList(String user_id){
		LikelistDAO likeDao = new LikelistDAO();
		return likeDao.getLikeList(user_id);
		
	}
	public boolean deleteList(int likelist_id) {
		LikelistDAO likeDao = new LikelistDAO();
		return likeDao.deleteList(likelist_id);
	}
	public boolean deleteList(String user_id) {
		LikelistDAO likeDao = new LikelistDAO();
		return likeDao.deleteList(user_id);
	}
}

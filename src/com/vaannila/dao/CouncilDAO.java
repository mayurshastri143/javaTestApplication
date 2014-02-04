/**
 * 
 */
package com.vaannila.dao;

import java.util.List;

import com.vaannila.domain.Council;

/**
 * @author Pirate
 *
 */
public interface CouncilDAO {
	
	public void saveOrUpdateCouncil(Council council);
	public List<Council> listCouncil();
	public Council listCouncilById(int id);
	public void deleteCouncil(int id);
	public Council selectCouncil(String councilName);
	
}

package map.link;

import java.util.HashMap;

public interface Province {
	public HashMap<Province,Integer> getNeighbors();
	public Integer getDistance(Province target);
	public String getProvinceName();
	public void setNeighbors();
	public Province yourPosition();
}

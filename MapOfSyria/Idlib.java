package map.link;

import java.util.HashMap;

import map.sasiedzi.Prowincje;

public class Idlib implements Province{
	private static Idlib instance = null;
	private final int unitLimit = 5;
	private int unitNumber = 0;
	private final String provinceName = "Idlib";
	private HashMap<Province,Integer> neighbors = new HashMap<Province,Integer>();
	//private List<NazwaKlasyJednostek> unitsList = new ArrayList<Nazwa>();
	   protected Idlib() {}
	   public static Idlib getInstance() {
	      if(instance == null) {
	         instance = new Idlib();
	      }
	      return instance;
	   }
	   public HashMap<Province,Integer> getNeighbors()
		{
			return neighbors;
		}
	   public Integer getDistance(Province target){
		   return neighbors.get(target);
	   }
		public String getProvinceName(){
			return this.provinceName;
		}
		public void setNeighbors(){
			neighbors.put(Latakia.getInstance(), 5);
			neighbors.put(Hama.getInstance(), 5);
			neighbors.put(Aleppo.getInstance(), 5);
		}
		public Province yourPosition(){
			return this;
		}
	}
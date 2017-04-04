package map;

import java.awt.Graphics2D;
import java.awt.geom.Area;
import java.util.HashMap;

import javax.swing.JPanel;

public class Country {
	private HashMap<String, Province> provinces = new HashMap<String, Province>();
	
	public Country(){
		provinces.put("Hama", new Province("Hama" , "Maps/Hama.png", "ISIS", 200.0, 200.0));
		provinces.put("Homs", new Province("Homs", "Maps/Homs.png", "ISIS", 189.0, 225.0));
		provinces.put("Rif Dimashq", new Province("Rif Dimashq", "Maps/Rif Dimashq.png", "USA", 175.0, 333.0));
		provinces.put("As-Suwayda", new Province("As-Suwayda", "Maps/As-Suwayda.png", "Assad", 208.0, 417.0));
		provinces.put("Deir ez-Zor", new Province("Deir ez-Zor", "Maps/Deir ez-Zor.png", "ISIS", 425.5, 139.5));
		provinces.put("Al-Hasakah", new Province("Al-Hasakah", "Maps/Al-Hasakah.png", "ISIS", 443.0, 67.0));
		provinces.put("Ar-Raqqah", new Province("Ar-Raqqah", "Maps/Ar-Raqqah.png", "Assad", 337.2, 113.1));
		provinces.put("Aleppo", new Province("Aleppo", "Maps/Aleppo.png", "Assad", 227.0, 100.0));
		provinces.put("Idlib", new Province("Idlib", "Maps/Idlib.png", "Assad", 197.0, 150.0));
		provinces.put("Latakia", new Province("Latakia", "Maps/Latakia.png", "Assad", 169.0, 187.0));
		provinces.put("Tartus", new Province("Tartus", "Maps/Tartus.png", "Assad", 177.0, 244.0));
		provinces.put("Dimashq", new Province("Dimashq", "Maps/Dimashq.png", "Assad", 202.0, 388.5));
		provinces.put("Daraa", new Province("Daraa", "Maps/Daraa.png", "USA", 172.5, 412.0));
		provinces.put("Quneitra", new Province("Quneitra", "Maps/Quneitra.png", "USA", 153.0, 406.0));
	}
	
	public void setCountry(String newProvince, String newController){
		if (newProvince != null) this.changeController(newProvince, newController);
	}
	
	public void emptyAll(Graphics2D g2){
		for (Province province : provinces.values()){
			province.empty(g2);
		}
	}
	
	public void paintMap(Graphics2D g2){
		provinces.get("Hama").paintProvince(g2);
		provinces.get("Homs").paintProvince(g2);
		provinces.get("Rif Dimashq").paintProvince(g2);
		provinces.get("As-Suwayda").paintProvince(g2);
		provinces.get("Deir ez-Zor").paintProvince(g2);
		provinces.get("Al-Hasakah").paintProvince(g2);
		provinces.get("Ar-Raqqah").paintProvince(g2);
		provinces.get("Aleppo").paintProvince(g2);
		provinces.get("Idlib").paintProvince(g2);
		provinces.get("Latakia").paintProvince(g2);
		provinces.get("Tartus").paintProvince(g2);
		provinces.get("Dimashq").paintProvince(g2);
		provinces.get("Daraa").paintProvince(g2);
		provinces.get("Quneitra").paintProvince(g2);
	}
	
	public void changeController(String provinceName, String newController){
		Province changed = provinces.get(provinceName);
		changed.setController(newController);
		provinces.replace(provinceName, changed);
	}
	
	public Area getArea(String provinceName){
		return provinces.get(provinceName).getArea();
	}
	
	public HashMap<String, Province> getProvinces(){
		return provinces;
	}
}

package data2;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class SuKien {
	private String time;
	private String tex;
	private String thoiKi;
	private String giaiDoan;
	private int index=0;
	private JSONArray SuKienList;
	public SuKien() {
		String url="https://vi.wikipedia.org/wiki/Ni%C3%AAn_bi%E1%BB%83u_l%E1%BB%8Bch_s%E1%BB%AD_Vi%E1%BB%87t_Nam";
		JSONObject Relate=new JSONObject();
		elements list= new elements(url,"div.mw-parser-output");
		for(Element stuff:list.getSec().select("meta~*")) {
			if(tex!=null) {
				if(list.getSec().select("dl").contains(stuff)) {
					for(Element dd:stuff.select("dd")) {
						time+=" "+dd.select("b").text();
						tex+=" "+dd.text();
						JSONObject SuKien=new JSONObject();
						if(time.contains("\u2013")) {
							time=time.replace("\u2013","-");
						}
						SuKien.put("Thoi gian",time);
						if(tex.contains("\u2013")) {
							tex=tex.replace("\u2013","-");
						}
						SuKien.put("Mo ta",tex);
						SuKien.put("id",index);
						SuKien.put("Giai doan",giaiDoan);
						SuKien.put("Thoi ki",thoiKi);
						SuKien.put("Lien quan",Relate);
						SuKienList.add(SuKien);
						Relate=new JSONObject();
					}
				}
				else {
					JSONObject SuKien=new JSONObject();
					index++;
					if(time.contains("\u2013")) {
						time=time.replace("\u2013","-");
					}
					SuKien.put("Thoi gian",time);
					if(tex.contains("\u2013")) {
						tex=tex.replace("\u2013","-");
					}
					SuKien.put("Mo ta",tex);
					SuKien.put("id",index);
					SuKien.put("Giai doan",giaiDoan);
					SuKien.put("Thoi ki",thoiKi);
					SuKien.put("Lien quan",Relate);
					SuKienList.add(SuKien);
					Relate=new JSONObject();
				}
				tex=null;
				time=null;
			}
			if(list.getSec().select("h2").contains(stuff)) {
				thoiKi=stuff.select("span.mw-headline").text();
			}
			if(list.getSec().select("h3").contains(stuff)) {
				giaiDoan=stuff.select("span.mw-headline").text();
			}
			if(list.getSec().select("p").contains(stuff)) {
				int ir=0;
				for(Element specify:stuff.select("a")) {
					ir++;
					tex=specify.attr("title");
					if(tex.contains("\u2013")) {
						tex=tex.replace("\u2013","-");
					}
					Relate.put(ir,tex);
				}
				time=stuff.select("b").text();
				tex=stuff.text();
			}
		}
	}
	public void wFile() {
		try(FileWriter file=new FileWriter("sukien.json")){
			file.write(SuKienList.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

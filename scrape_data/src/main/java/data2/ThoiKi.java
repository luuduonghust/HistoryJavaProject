package data2;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ThoiKi {
	private String mota;
	private String thoiki;
	private int index=0;
	private JSONArray ThoiKiList;
	public void get(String tof) {
		String url="https://nguoikesu.com";
		elements doc=new elements(url+tof,"div.blog h2 span");
		thoiki=doc.getSec().text();
		for(Element ele:doc.getSec().select("div.items-leading.clearfix div[itemprop=blogPost]")) {
			JSONObject ThoiKi=new JSONObject();
			String giaidoan=ele.select("div.page-header h2").text();
			for(Element choose:ele.select("p")) { 
				mota=choose.text(); 
				ThoiKi.put("Mo ta", mota);
				break;
			}
			String link=ele.select("div.page-header h2 a").attr("href");
			ThoiKi.put("relate", elements.getRelate(url));
			ThoiKi.put("Thoi Ki", thoiki);
			ThoiKi.put("Giai doan", giaidoan);
			ThoiKiList.add(ThoiKi);
			index++;
		}
	}
	public void run() {
		String url = "https://nguoikesu.com";
		Document doc = null;
	    try {
	        doc = Jsoup
	                .connect(url)
	                .userAgent("Jsoup client")
	                .timeout(200000).get();
	        Elements spans=doc.select("div.jm-module-in");
	        for(Element ele:spans) {
	        	if(ele.select("h3.jm-title").text().equals("CÁC THỜI KỲ LỊCH SỬ")) {
	        		Elements lis=ele.select("ul.jm-red.list-categories.title-star-ms li.level-0>a");
	        		for(Element li:lis) {
	        			get(li.attr("href"));
	        		}
	        		
	        	}
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	public void wFile() {
		try(FileWriter file=new FileWriter("thoiki.json")){
			file.write(ThoiKiList.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

package data2;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class LeHoi {
	private int index=0;
	private String name;
	private JSONArray LeHoiList;
	public LeHoi() {
		String url="https://vi.wikipedia.org/wiki/C%C3%A1c_ng%C3%A0y_l%E1%BB%85_%E1%BB%9F_Vi%E1%BB%87t_Nam";
		elements table= new elements(url,"div.mw-parser-output table");
		for(Element row:table.getSec().select("tr~tr")) {
			JSONObject LeHoi = new JSONObject();
			image img=new image(name);
			LeHoi.put("id", index);
			LeHoi.put("ten", name=row.select("td").get(1).text());
			LeHoi.put("ngayToChuc", row.select("td").get(0).text());
			LeHoi.put("diaDiem", row.select("td").get(2).text());
			LeHoi.put("image", img.getImg());
			String tof=row.select("td a").get(1).attr("href");
			String url1="https://vi.wikipedia.org";
			elements choose= new elements(url1,"div.mw-parser-output p");
			for(Element element:choose.getSec()) {
				LeHoi.put("moTa", element.text());
				break;
			}
			LeHoiList.add(LeHoi);
			index++;
		}
	}
	public void wFile() {
		try(FileWriter file=new FileWriter("lehoi.json")){
			file.write(LeHoiList.toJSONString());
			file.flush();
		}catch (IOException e) {
	        e.printStackTrace();
	    }
	}
}

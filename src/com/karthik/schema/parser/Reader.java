package com.karthik.schema.parser;

import java.io.File;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import com.karthik.schema.ObjectFactory;
import com.karthik.schema.TUrl;
import com.karthik.schema.Urlset;
import com.sun.xml.internal.ws.util.Pool.Marshaller;

public class Reader {

	public static void main(String[] args) throws JAXBException {
		
		JAXBContext context = JAXBContext.newInstance(ObjectFactory.class);
		javax.xml.bind.Unmarshaller unmarchaller = context.createUnmarshaller();
		Urlset urlset = (Urlset)unmarchaller.unmarshal(new File("sitemap.xml"));
		List<TUrl> urlList = urlset.getUrl();
		for(TUrl typeUrl :urlList){
			System.out.println(typeUrl.getLoc());
		}
		
		TUrl url = new TUrl();
		url.setLoc("http://www.test.com");
		
		urlList.add(url);
		
		javax.xml.bind.Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(urlset, new File("newSiteMap.xml"));
		
		
	}

}

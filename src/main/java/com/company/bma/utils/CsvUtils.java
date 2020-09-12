package com.company.bma.utils;

import java.io.PrintWriter;
import java.util.List;

import com.company.bma.model.Card;
import com.company.bma.model.ShortUrl;

import lombok.extern.log4j.Log4j2;

@Log4j2
public class CsvUtils {
	private static Integer SERIAL_NO = 0;

	public static void downloadCsv(PrintWriter printWriter, List<ShortUrl> shortUrl) {
		log.info("----Writing csv for------"+shortUrl);
		printWriter.write("No, ShortUrl, LongUrl, ExpiryDate \n");
		shortUrl.forEach(surl->{
		printWriter.write(++SERIAL_NO+","+surl.getSurl()+","+surl.getLurl()+","+surl.getExpiryDate());
		});
	}

	public static void downloadCardCsv(PrintWriter printWriter, List<Card> exportsCards) {
		log.info("----Writing csv for------"+exportsCards);
		printWriter.write("No,Card Title,Card Description, ShortUrl, LongUrl, ExpiryDate \n");
		exportsCards.forEach(card->{
		printWriter.write(++SERIAL_NO+","+card.getTitle()+card.getDescription()+"\n");
		});
		
	}
}

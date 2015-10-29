package com.einstitute.core.domain.util;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

import com.einstitute.core.domain.EntityGroup;

public abstract class MongoDomainUtil {

	public static final String newStringId(Class<?> clazz) {
		return getDateString() + getCollectionName(clazz);
	}
	
	public static final ObjectId newObjectId(Class<?> clazz) {
		
		
		String hexString = Integer.toHexString(new Integer(getDateString()).intValue());
		return new ObjectId(hexString);
		
	}

	private static String getDateString() {
		return new SimpleDateFormat("ddMMyyyyhhmmss").format(new Date());
	}

	public static String getCollectionName(Class<?> clazz) {
		Document mongoDocAnnot = clazz.getAnnotation(Document.class);
		String collectionName = mongoDocAnnot.collection();
		
		return collectionName;
	}
	
	public static void main(String[] args) {
		System.out.println("ID: " + newObjectId(EntityGroup.class));
	}
}

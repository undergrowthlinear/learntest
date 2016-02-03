/*package com.learnback.work.proto;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Test;

import com.learnback.work.proto.ContactInfos.Contact;
import com.learnback.work.proto.ContactInfos.Contact.Builder;
import com.learnback.work.proto.ContactInfos.Contact.Person;
import com.learnback.work.proto.ContactInfos.Contact.Person.PhoneNumber;
import com.learnback.work.proto.ContactInfos.Contact.Person.PhoneType;
import com.learnback.work.proto.ContactInfos.Contact.Person.SexType;

public class ContactInfosTest {

	@Test
	public void testWrite() throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		try (FileOutputStream outputStream = new FileOutputStream("contact.txt");) {
			ContactInfos.Contact.Builder contact = ContactInfos.Contact.newBuilder();
			addPersons(contact);
			contact.build().writeTo(outputStream);
			System.out.println(contact.build().toByteArray());
		}

	}

	@Test
	public void testRead() throws FileNotFoundException, IOException {
		ContactInfos.Contact contact = ContactInfos.Contact.parseFrom(new FileInputStream("contact.txt"));
		disContact(contact);
	}

	private void disContact(Contact contact) {
		// TODO Auto-generated method stub
		for (Contact.Person person : contact.getPersonsList()) {
			System.out.println(person.toString());
		}
	}

	private void addPersons(Builder contact) {
		// TODO Auto-generated method stub
		ContactInfos.Contact.Person.Builder person = createPerson();
		contact.addPersons(person);
	}

	private com.learnback.work.proto.ContactInfos.Contact.Person.Builder createPerson() {
		// TODO Auto-generated method stub
		ContactInfos.Contact.Person.Builder person = ContactInfos.Contact.Person.newBuilder();
		person.setId(new Random().nextInt(1000));
		person.setName(RandomStringUtils.random(10, "a-z"));
		PhoneNumber.Builder phone = createPhones(person);
		person.addPhoneNumber(phone);
		person.setSexType(SexType.MALE);
		person.setEmail("google.com");
		return person;
	}

	private com.learnback.work.proto.ContactInfos.Contact.Person.PhoneNumber.Builder createPhones(
			com.learnback.work.proto.ContactInfos.Contact.Person.Builder person) {
		// TODO Auto-generated method stub
		PhoneNumber.Builder builder = PhoneNumber.newBuilder();
		builder.setPhone(String.format("%011d", new Random().nextInt(100000000)));
		builder.setPhoneType(PhoneType.HOME);
		return builder;
	}

}
*/
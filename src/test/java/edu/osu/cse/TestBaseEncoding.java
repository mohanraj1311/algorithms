package edu.osu.cse;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TestBaseEncoding {

	@Test
	public void testBaseEncode() {
		assertEquals("1000", BaseEncoding.encode(8, 2));
		assertEquals("8", BaseEncoding.encode(8, 16));
		assertEquals("ff", BaseEncoding.encode(255, 16));
		assertEquals("fe", BaseEncoding.encode(254, 16));
		
		assertEquals("TWFu", BaseEncoding.base64Encode("Man"));
		assertEquals("YW55", BaseEncoding.base64Encode("any"));
		assertEquals("cGxlYXN1cmUu", BaseEncoding.base64Encode("pleasure."));
		assertEquals("bGVhc3VyZS4=", BaseEncoding.base64Encode("leasure."));
		assertEquals("ZWFzdXJlLg==", BaseEncoding.base64Encode("easure."));
		assertEquals("YXN1cmUu", BaseEncoding.base64Encode("asure."));
		assertEquals("c3VyZS4=", BaseEncoding.base64Encode("sure."));
		assertEquals("aGVsbG8=", BaseEncoding.base64Encode("hello"));
		assertEquals("cHJhc2FudGg=", BaseEncoding.base64Encode("prasanth"));
		
	}
}

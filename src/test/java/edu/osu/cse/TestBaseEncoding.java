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
		assertEquals("256", BaseEncoding.encode(256, 10));
		assertEquals("-256", BaseEncoding.encode(-256, 10));
		
		assertEquals(8, BaseEncoding.decode("1000", 2));
		assertEquals(8, BaseEncoding.decode("8", 16));
		assertEquals(256, BaseEncoding.decode("256", 10));
		assertEquals(-256, BaseEncoding.decode("-256", 10));
		assertEquals(255, BaseEncoding.decode("ff", 16));
		assertEquals(254, BaseEncoding.decode("fe", 16));
		assertEquals(2587, BaseEncoding.decode("a1b", 16));
		assertEquals(2587, BaseEncoding.decode("A1B", 16));
		assertEquals(10613644, BaseEncoding.decode("a1f38c", 16));
		assertEquals(10, BaseEncoding.decode("a", 16));
		assertEquals(2, BaseEncoding.decode("00010", 2));
		
		assertEquals("TWFu", BaseEncoding.base64Encode("Man"));
		assertEquals("YW55", BaseEncoding.base64Encode("any"));
		assertEquals("cGxlYXN1cmUu", BaseEncoding.base64Encode("pleasure."));
		assertEquals("bGVhc3VyZS4=", BaseEncoding.base64Encode("leasure."));
		assertEquals("ZWFzdXJlLg==", BaseEncoding.base64Encode("easure."));
		assertEquals("YXN1cmUu", BaseEncoding.base64Encode("asure."));
		assertEquals("c3VyZS4=", BaseEncoding.base64Encode("sure."));
		assertEquals("aGVsbG8=", BaseEncoding.base64Encode("hello"));
		assertEquals("cHJhc2FudGg=", BaseEncoding.base64Encode("prasanth"));
		assertEquals("aGVsbG8gcHJhc2FudGg=", BaseEncoding.base64Encode("hello prasanth"));
		assertEquals("aCBvIHcgdCBvIGggYSBuIGQgbCBlIHMgcCBhIGMgZQ==", BaseEncoding.base64Encode("h o w t o h a n d l e s p a c e"));
	}
}

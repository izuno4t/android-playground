package net.noworks.android.ui.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(JUnit4.class)
public class JaStringUtilsTest {

	@Test
	public void testKkanaHanToZen() {
		assertEquals("半角ﾠカタカナ", JaStringUtils.kkanaHanToZen("半角ﾠｶﾀｶﾅ"));
	}

	@Test
	public void testKkanaZenToHan() {
		assertEquals("全角ｶﾀｶﾅあ", JaStringUtils.kkanaZenToHan("全角カタカナあ"));
	}

	@Test
	public void testLatinHanToZen() {
		assertEquals("ＡＢＣ±" + Character.valueOf((char) 0x0020),
				JaStringUtils.latinHanToZen("ABC±" + Character.valueOf((char) 0x0020)));
	}

	@Test
	public void testLatinZenToHan() {
		assertEquals("ABCｱ" + Character.valueOf((char) 0xfe30),
				JaStringUtils.latinZenToHan("ＡＢＣｱ" + Character.valueOf((char) 0xfe30)));
	}

	@Test
	public void testKkanaToHkana() {
		assertEquals("全角かなあ", JaStringUtils.kkanaToHkana("全角カナあ"));
	}

	@Test
	public void testHkanaToKkana() {
		assertEquals("【全角カナ】", JaStringUtils.hkanaToKkana("【全角かな】"));
	}

	@Test
	public void testNumZenToHan() {
		assertEquals("123＆ＡＢＣ", JaStringUtils.numZenToHan("１２３＆ＡＢＣ"));
	}

	@Test
	public void testHAlphabetToKAlphabet() {
		assertEquals("abcABC１２３ｱｲｳ", JaStringUtils.hAlphabetToKAlphabet("ａｂｃＡＢＣ１２３ｱｲｳ"));
	}

	@Test
	public void testTrim() {
		assertEquals("abc", JaStringUtils.trim("　 abc 　"));
	}

	@Test
	public void testTrim_null() {
		assertNull(JaStringUtils.trim(null));
	}

	@Test
	public void testTrim_blank() {
		assertEquals("", JaStringUtils.trim(""));
	}

	@Test
	public void testTrim_lastBlank() {
		assertEquals("a", JaStringUtils.trim("a "));
	}
}

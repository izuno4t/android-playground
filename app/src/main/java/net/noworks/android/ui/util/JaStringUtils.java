package net.noworks.android.ui.util;

public class JaStringUtils {

	private JaStringUtils() {
	}

	// 半角カタカナ<-->全角カタカナ変換テーブル
	private static final String kanaHanZenTbl[][] = {
			// 2文字構成の濁点付き半角カナ
			// 必ずテーブルに先頭に置いてサーチ順を優先すること
			{ "ｶﾞ", "ガ" }, { "ｷﾞ", "ギ" }, { "ｸﾞ", "グ" }, { "ｹﾞ", "ゲ" }, { "ｺﾞ", "ゴ" }, { "ｻﾞ", "ザ" }, { "ｼﾞ", "ジ" },
			{ "ｽﾞ", "ズ" }, { "ｾﾞ", "ゼ" }, { "ｿﾞ", "ゾ" }, { "ﾀﾞ", "ダ" }, { "ﾁﾞ", "ヂ" }, { "ﾂﾞ", "ヅ" }, { "ﾃﾞ", "デ" },
			{ "ﾄﾞ", "ド" }, { "ﾊﾞ", "バ" }, { "ﾋﾞ", "ビ" }, { "ﾌﾞ", "ブ" },
			{ "ﾍﾞ", "ベ" },
			{ "ﾎﾞ", "ボ" },
			{ "ﾊﾟ", "パ" },
			{ "ﾋﾟ", "ピ" },
			{ "ﾌﾟ", "プ" },
			{ "ﾍﾟ", "ペ" },
			{ "ﾎﾟ", "ポ" },
			{ "ｳﾞ", "ヴ" },
			// 1文字構成の半角カナ
			{ "ｱ", "ア" }, { "ｲ", "イ" }, { "ｳ", "ウ" }, { "ｴ", "エ" }, { "ｵ", "オ" }, { "ｶ", "カ" }, { "ｷ", "キ" },
			{ "ｸ", "ク" }, { "ｹ", "ケ" }, { "ｺ", "コ" }, { "ｻ", "サ" }, { "ｼ", "シ" }, { "ｽ", "ス" }, { "ｾ", "セ" },
			{ "ｿ", "ソ" }, { "ﾀ", "タ" }, { "ﾁ", "チ" }, { "ﾂ", "ツ" }, { "ﾃ", "テ" }, { "ﾄ", "ト" }, { "ﾅ", "ナ" },
			{ "ﾆ", "ニ" }, { "ﾇ", "ヌ" }, { "ﾈ", "ネ" }, { "ﾉ", "ノ" }, { "ﾊ", "ハ" }, { "ﾋ", "ヒ" }, { "ﾌ", "フ" },
			{ "ﾍ", "ヘ" }, { "ﾎ", "ホ" }, { "ﾏ", "マ" }, { "ﾐ", "ミ" }, { "ﾑ", "ム" }, { "ﾒ", "メ" }, { "ﾓ", "モ" },
			{ "ﾔ", "ヤ" }, { "ﾕ", "ユ" }, { "ﾖ", "ヨ" }, { "ﾗ", "ラ" }, { "ﾘ", "リ" }, { "ﾙ", "ル" }, { "ﾚ", "レ" },
			{ "ﾛ", "ロ" }, { "ﾜ", "ワ" }, { "ｦ", "ヲ" }, { "ﾝ", "ン" }, { "ｧ", "ァ" }, { "ｨ", "ィ" }, { "ｩ", "ゥ" },
			{ "ｪ", "ェ" }, { "ｫ", "ォ" }, { "ｬ", "ャ" }, { "ｭ", "ュ" }, { "ｮ", "ョ" }, { "ｯ", "ッ" }, { "｡", "。" },
			{ "｢", "「" }, { "｣", "」" }, { "､", "、" }, { "･", "・" }, { "ｰ", "ー" }, { "", "" } };

	/**
	 * 文字列に含まれる半角カナを全角カナに変換するメソッド
	 * 
	 * @param p
	 *            変換する半角カナ文字列
	 * @return 変換後の全角カナ文字列
	 */
	public static String kkanaHanToZen(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0, j = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode半角カタカナのコード範囲か調べます
			if (c.compareTo(Character.valueOf((char) 0xff61)) >= 0
					&& c.compareTo(Character.valueOf((char) 0xff9f)) <= 0) {
				// 半角全角変換テーブルから半角カナにマッチするエントリを探し、
				// 対応する全角カナを取得して戻り文字列へセットします
				for (j = 0; j < kanaHanZenTbl.length; j++) {
					if (p.substring(i).startsWith(kanaHanZenTbl[j][0])) {
						str = str + kanaHanZenTbl[j][1];
						i += kanaHanZenTbl[j][0].length() - 1;
						break;
					}
				}
				// 半角全角変換テーブルに半角カナにマッチするエントリがなければ
				// 変換せずにそのまま戻り文字列へセットします
				if (j >= kanaHanZenTbl.length) {
					str = str + p.substring(i, i + 1);
				}
			} else { // Unicode半角カタカナ以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる全角カナを半角カナに変換するメソッド
	 * 
	 * @param p
	 *            変換する全角カナ文字列
	 * @return 変換後の半角カナ文字列
	 */
	public static String kkanaZenToHan(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0, j = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode全角カタカナのコード範囲か調べます
			if (c.compareTo(Character.valueOf((char) 0x30a1)) >= 0
					&& c.compareTo(Character.valueOf((char) 0x30fc)) <= 0) {
				// 半角全角変換テーブルから全角カナにマッチするエントリを探し、
				// 対応する半角カナを取得して戻り文字列へセットします
				for (j = 0; j < kanaHanZenTbl.length; j++) {
					if (p.substring(i).startsWith(kanaHanZenTbl[j][1])) {
						str = str + kanaHanZenTbl[j][0];
						break;
					}
				}
				// 半角全角変換テーブルの全角カナにマッチするエントリがなければ
				if (j >= kanaHanZenTbl.length) {
					str = str + p.substring(i, i + 1);
				}
			} else { // 全角カタカナ以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる半角ラテン基本文字を全角ラテン基本文字に変換するメソッド
	 * 
	 * @param p
	 *            変換する半角ラテン基本文字列
	 * @return 変換後の全角ラテン基本文字列
	 */
	public static String latinHanToZen(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode半角ラテン文字のコード範囲(!～~)であるか調べます
			if (c.compareTo(Character.valueOf((char) 0x0021)) >= 0
					&& c.compareTo(Character.valueOf((char) 0x007e)) <= 0) {
				// 変換文字に0xfee0を加算して全角文字に変換します
				Character x = Character
						.valueOf((char) (c.charValue() + (Character.valueOf((char) 0xfee0)).charValue()));
				// 文字列としてセットします
				str = str + x.toString();
			} else { // 半角ラテン文字以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる全角ラテン文字を半角ラテン文字に変換するメソッド
	 * 
	 * @param p
	 *            変換する全角ラテン文字列
	 * @return 変換後の半角ラテン文字列
	 */
	public static String latinZenToHan(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode全角ラテン文字のコード範囲(！から～)であるか調べます
			if (c.compareTo(Character.valueOf((char) 0xff01)) >= 0
					&& c.compareTo(Character.valueOf((char) 0xff5e)) <= 0) {
				// 変換文字から0xfee0を減算して半角文字に変換します
				Character x = Character
						.valueOf((char) (c.charValue() - (Character.valueOf((char) 0xfee0)).charValue()));
				// 文字列としてセットします
				str = str + x.toString();
			} else { // 全角ラテン文字以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる全角カナを全角かなに変換するメソッド
	 * 
	 * @param p
	 *            変換する全角カナ文字列
	 * @return 変換後の全角かな文字列
	 */
	public static String kkanaToHkana(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode全角カタカナのコード範囲(ァ～ン)であるか調べます
			if (c.compareTo(Character.valueOf((char) 0x30a1)) >= 0
					&& c.compareTo(Character.valueOf((char) 0x30f3)) <= 0) {
				// 全角カナ文字から0x0060を減算して全角かな文字に変換します
				Character x = Character
						.valueOf((char) (c.charValue() - (Character.valueOf((char) 0x0060)).charValue()));
				// 文字列としてセットします
				str = str + x.toString();
			} else { // 全角カタカナ以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる全角かなを全角カナに変換するメソッド
	 * 
	 * @param p
	 *            変換する全角かな文字列
	 * @return 変換後の全角カナ文字列
	 */
	public static String hkanaToKkana(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode全角ひらがなのコード範囲(ぁ～ん)であるか調べます
			if (c.compareTo(Character.valueOf((char) 0x3041)) >= 0
					&& c.compareTo(Character.valueOf((char) 0x3093)) <= 0) {
				// 全角かな文字に0x0060を加算して全角カナ文字に変換します
				Character x = Character
						.valueOf((char) (c.charValue() + (Character.valueOf((char) 0x0060)).charValue()));
				// 文字列としてセットします
				str = str + x.toString();
			} else { // 全角カタカナ以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列に含まれる全角数字を半角数字に変換するメソッド
	 * 
	 * @param p
	 *            変換する全角数字文字列
	 * @return 変換後の半角数字文字列
	 */
	public static String numZenToHan(String p) {
		String str = "";

		for (int i = 0; i < p.length(); i++) {
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			if (c.compareTo(Character.valueOf((char) 0xff10)) >= 0
					&& c.compareTo(Character.valueOf((char) 0xff19)) <= 0) {
				Character x = Character
						.valueOf((char) (c.charValue() - (Character.valueOf((char) 0xfee0)).charValue()));
				str = str + x.toString();
			} else {
				str = str + p.substring(i, i + 1);
			}
		}
		return str;
	}

	/**
	 * 文字列に含まれる全角英字を全角英字に変換するメソッド
	 * 
	 * @param p
	 *            変換する全角英字文字列
	 * @return 変換後の全角英字文字列
	 */
	public static String hAlphabetToKAlphabet(String p) {
		String str = "";
		// パラメータの文字列を先頭から1文字づつ調べます
		for (int i = 0; i < p.length(); i++) {
			// 文字列から１文字取り出します
			Character c = Character.valueOf(p.substring(i, i + 1).charAt(0));
			// Unicode全角英字のコード範囲(ａ～ｚ,Ａ～Ｚ)であるか調べます
			if (c >= 'ａ' && c <= 'ｚ') {
				Character x = Character.valueOf((char) (c - 'ａ' + 'a'));
				str = str + x.toString();
			} else if (c >= 'Ａ' && c <= 'Ｚ') {
				Character x = Character.valueOf((char) (c - 'Ａ' + 'A'));
				str = str + x.toString();
			} else { // 全角英字以外なら変換せずにそのまま戻り文字列へセットします
				str = str + p.substring(i, i + 1);
			}
		}
		// 変換後文字列を戻します
		return str;
	}

	/**
	 * 文字列からスペース文字をトリミングするメソッド
	 * @param p
	 *            トリミング対象の文字列
	 * @return トリミング後の文字列
	 */
	public static String trim(String p) {
		if (null == p)
			return p;

		int count = p.length();
		int len = count;
		int st = 0;

		while ((st < len) && (p.charAt(st) <= 0x0020 || p.charAt(st) == 0x3000)) {
			st++;
		}
		while ((st < len) && (p.charAt(len - 1) <= 0x0020 || p.charAt(len - 1) == 0x3000)) {
			len--;
		}
		return ((st > 0) || (len < count)) ? p.substring(st, len) : p;
	}
	
	/**
	 * 文字列1がnullの場合に文字列2を返します。
	 * 
	 * @param s1
	 *            文字列1
	 * @param s2
	 *            文字列2
	 * @return 結果の文字列
	 */
	public static String ifnull(String s1, String s2) {
		if (s1 == null) {
			return s2;
		}
		return s1;
	}
}

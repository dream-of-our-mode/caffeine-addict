package com.caffeineaddict.caffeineaddictmode;

public enum TagNSpecialConstant {
    QUALITY("Quality"),
    BARISTA("Barista"),
    LAST_USEDBY("LastUsedBy"),
    STAR("★");

    final String text;
    TagNSpecialConstant(String text){ this.text = text;}

    public String getText() {
        return text;
    }
    public String getRepeatText(int n){
        return text.repeat(n);
    }
}

package com.study.august.effective.object.test;


import java.util.Comparator;
import java.util.Objects;

/**
 * @description: CaseInsensitiveString
 * @date: 2020/8/2
 * @author: likanghai
 */
public class CaseInsensitiveString implements Cloneable, Comparator<CaseInsensitiveString> {

    private final String s;

    public CaseInsensitiveString(String s){
        if(s == null){
            throw new NullPointerException();
        }
        this.s = s;
    }

    @Override
    public int compare(CaseInsensitiveString o1, CaseInsensitiveString o2) {
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CaseInsensitiveString)) return false;
        CaseInsensitiveString that = (CaseInsensitiveString) o;
        return Objects.equals(s, that.s);
    }

    @Override
    public int hashCode() {
        return Objects.hash(s);
    }
    
    
    public CaseInsensitiveString clone() throws CloneNotSupportedException {
        return (CaseInsensitiveString) super.clone();
    }
}

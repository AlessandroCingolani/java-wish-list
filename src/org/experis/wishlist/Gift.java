package org.experis.wishlist;

public class Gift implements Comparable<Gift> {

    private String name;

    public Gift(java.lang.String name) {
        this.name = name;
    }


    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Gift{" +
                "name='" + name + '\'' +
                '}'+"\n";
    }


    // override metodo compare per controllare il name e ordinarlo con il sort
    @Override
    public int compareTo(Gift o) {
        return this.getName().compareTo(o.getName());
    }
}

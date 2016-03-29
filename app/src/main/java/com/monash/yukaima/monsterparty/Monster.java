package com.monash.yukaima.monsterparty;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by yukaima on 22/03/16.
 */
public class Monster implements Parcelable {

    private String name;
    private String type;
    private int level;
    private int attackNumber;

    public Monster() {
        this.name = "Unknown com.monash.yukaima.monsterparty.Monster";
        this.type = "Unknown Type";
        this.level = 0;
        this.attackNumber = 0;
    }
    public Monster(String name, String type, int level,int attackNumber) {
        this.name = name;
        this.type = type;
        this.level = level;
        this.attackNumber = attackNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttackPower() {
        return attackNumber;
    }

    public void setAttackNumber(int attackNumber) {
        this.attackNumber = attackNumber;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    protected Monster(Parcel in) {
        name = in.readString();
        type = in.readString();
        level = in.readInt();
        attackNumber = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(type);
        dest.writeInt(level);
        dest.writeInt(attackNumber);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Monster> CREATOR = new Parcelable.Creator<Monster>() {
        @Override
        public Monster createFromParcel(Parcel in) {
            return new Monster(in);
        }

        @Override
        public Monster[] newArray(int size) {
            return new Monster[size];
        }
    };
}
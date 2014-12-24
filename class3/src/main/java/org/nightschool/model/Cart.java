package org.nightschool.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by gc on 2014/12/6.
 */
public class Cart {

    private final List<Disk> disks = new ArrayList<>();

    public List<Disk> getDisks() {
        return disks;
    }

    public void addDisk(Disk disk) {
        disks.add(disk);
    }

    public int countKinds() {
        HashSet<Disk> diskSet = new HashSet<>();

        for (Disk disk : disks) {
            diskSet.add(disk);
        }
        return diskSet.size();
    }

    public void removeDisk(Disk disk){
        int count = 0;
        for (Disk d : disks) {
            if (d.equals(disk)){
                count++;
            }
        }
        int i = 0;
        while (i<count){
            disks.remove(disk);
            i++;
        }
    }

    public double totalPrice(){
        Disk fancyDisk = new Disk();
        int fancyDiskNums = 0;
        int marriageDiskNums = 0;
        int TDiskNums = 0;
        double totalPromotePrice;
        double fancyDiskPrice = 0;
        double marriageDiskPrice = 0;
        double TDiskPrice = 0;

        for (Disk disk : disks) {
            if (disk.getName().equals("小清新光盘")) {
                fancyDiskNums++;
                fancyDiskPrice = disk.getPrice();
                fancyDisk = disk;
            }
            if (disk.getName().equals("婚庆光盘")) {
                marriageDiskNums++;
                marriageDiskPrice = disk.getPrice();
            }
            if (disk.getName().equals("1TB大容量光盘")) {
                TDiskNums++;
                TDiskPrice = disk.getPrice();
            }

        }
            // 小清新光盘满二送一
            for (int i = 0; i < fancyDiskNums / 2; i++)
                disks.add(fancyDisk);
            // marriagePrice = marriageDiskNums * marriageDiskPrice; 这样变量太多
            //marriagePrice -= marriagePrice/100 *10;
            //TPrice = TDiskNums * TDiskPrice * 0.95;

            // 促销总价格计算
           totalPromotePrice = fancyDiskNums * fancyDiskPrice + (marriageDiskNums * marriageDiskPrice -(int) (marriageDiskNums * marriageDiskPrice / 100 * 10))+ TDiskNums * TDiskPrice * 0.95;

              return totalPromotePrice;

        }




}








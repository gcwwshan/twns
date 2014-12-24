package org.nightschool.model;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

/**
 * Created by gc on 2014/12/6.
 */
public class CartTest {
    private Cart cart;

    @Before
    public void setUp() throws Exception {
        cart = new Cart();
    }

    @Test
    public void should_cart_be_empty_when_no_disk_added() throws Exception {
        List<Disk> disks = cart.getDisks();
        assertThat(disks.size(), is(0));

    }


    @Test
    public void should_be_able_to_add_disk_to_cart () throws Exception {
            Disk disk = new Disk();
            cart.addDisk(disk);
        List<Disk> disks = cart.getDisks();
        assertThat(disks.size(), is(1));
    }

    @Test
    public void should_be_able_to_count_kinds_of_disks() throws Exception {
        Disk fancyDisk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张",3.5);
        Disk marriageDisk = new Disk("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张",5);
        cart.addDisk(fancyDisk);
        cart.addDisk(fancyDisk);
        cart.addDisk(marriageDisk);
        cart.addDisk(marriageDisk);
        assertThat(cart.countKinds(),is(2));
    }

    @Test
    public void should_be_able_to_get_disk_properties() throws Exception {
        Disk disk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张",3.5);
        cart.addDisk(disk);
        Disk disk1 = cart.getDisks().get(0);
        assertThat(disk1.getName(),is("小清新光盘"));
        assertThat(disk1.getImgUrl(),is("../images/disk/fancy-disk.jpg"));
        assertThat(disk1.getDesc(),is("小清新、小文艺 35元/10张"));
        assertThat(disk1.getPrice(),is(3.5));
    }

    @Test
    public void should_be_able_to_remove_disk_from_cart() throws Exception {
        Disk fancyDisk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张",3.5);
        Disk marriageDisk = new Disk("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张",5);
         cart.addDisk(fancyDisk);
         cart.addDisk(fancyDisk);
         cart.addDisk(marriageDisk);
         cart.removeDisk(fancyDisk);
        assertThat(cart.getDisks().size(),is(1));
    }

    @Test
    public void should_be_able_to_calculate_total_prcie() throws Exception {
        Disk fancyDisk = new Disk("小清新光盘", "../images/disk/fancy-disk.jpg", "小清新、小文艺 35元/10张",3.5);
        Disk marriageDisk = new Disk("婚庆光盘", "../images/disk/marriage-disk.jpg", "记录你的美好瞬间 50元/10张",5);
         for(int i = 0;i < 10;i++){
           cart.addDisk(fancyDisk);
        }
        cart.addDisk(marriageDisk);
        assertThat(cart.totalPrice(),is(40.0));  // 测试促销总价格
        assertThat(cart.getDisks().size(),is(16)); // 测试小清新光盘买二送一, 测试时需要在测试总价格断言的下面，才会测试正确，因为totalPrice里有增加额外光盘的语句
        }
        }



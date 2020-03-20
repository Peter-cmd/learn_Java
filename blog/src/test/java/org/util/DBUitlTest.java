package org.util;

import org.junit.Assert;
import org.junit.Test;

public class DBUitlTest {
    @Test
    public void testConnection(){
        Assert.assertNotNull(DBUtil.getConnection());
    }
}

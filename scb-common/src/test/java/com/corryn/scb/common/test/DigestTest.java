/**
 * This file is part of the SCB project
 */
package com.corryn.scb.common.test;

import org.junit.Assert;
import org.junit.Test;

import com.corryn.scb.common.security.Digest;

/**
 * @author Romana Schubert
 *
 */
public class DigestTest
{
    /**
     * toMD5Test
     */
    @Test
    public void toMD5Test()
    {
	Assert.assertEquals("5d41402abc4b2a76b9719d911017c592", Digest.toMD5("hello"));
    }

    /**
     * matchMD5Test
     */
    @Test
    public void matchMD5Test()
    {
	final String hello = "hello";
	Assert.assertEquals(Digest.toMD5(hello), Digest.toMD5(hello));
    }
}

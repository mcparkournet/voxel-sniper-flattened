package com.thevoxelbox.voxelsniper;

import java.util.Set;
import com.google.common.collect.Multimap;
import com.thevoxelbox.voxelsniper.brush.IBrush;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 */
public class BrushesTest {

	private Brushes brushes;

	@Before
	public void setUp() throws Exception {
        this.brushes = new Brushes();
	}

	@Test
	public void testRegisterSniperBrush() throws Exception {
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
	}

	@Test
	public void testGetBrushForHandle() throws Exception {
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
		Assert.assertSame(brush.getClass(), this.brushes.getBrushForHandle("mockhandle"));
		Assert.assertSame(brush.getClass(), this.brushes.getBrushForHandle("testhandle"));
		Assert.assertNull(this.brushes.getBrushForHandle("notExistant"));
	}

	@Test
	public void testRegisteredSniperBrushes() throws Exception {
		Assert.assertEquals(0, this.brushes.registeredSniperBrushes());
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
		Assert.assertEquals(1, this.brushes.registeredSniperBrushes());
	}

	@Test
	public void testRegisteredSniperBrushHandles() throws Exception {
		Assert.assertEquals(0, this.brushes.registeredSniperBrushHandles());
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
		Assert.assertEquals(2, this.brushes.registeredSniperBrushHandles());
	}

	@Test
	public void testGetSniperBrushHandles() throws Exception {
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
		Set<String> sniperBrushHandles = this.brushes.getSniperBrushHandles(brush.getClass());
		Assert.assertTrue(sniperBrushHandles.contains("mockhandle"));
		Assert.assertTrue(sniperBrushHandles.contains("testhandle"));
		Assert.assertFalse(sniperBrushHandles.contains("notInSet"));
	}

	@Test
	public void testGetRegisteredBrushesMultimap() throws Exception {
		IBrush brush = Mockito.mock(IBrush.class);
        this.brushes.registerSniperBrush(brush.getClass(), "mockhandle", "testhandle");
		Multimap<Class<? extends IBrush>, String> registeredBrushesMultimap = this.brushes.getRegisteredBrushesMultimap();
		Assert.assertTrue(registeredBrushesMultimap.containsKey(brush.getClass()));
		Assert.assertFalse(registeredBrushesMultimap.containsKey(IBrush.class));
		Assert.assertTrue(registeredBrushesMultimap.containsEntry(brush.getClass(), "mockhandle"));
		Assert.assertTrue(registeredBrushesMultimap.containsEntry(brush.getClass(), "testhandle"));
		Assert.assertFalse(registeredBrushesMultimap.containsEntry(brush.getClass(), "notAnEntry"));
	}
}
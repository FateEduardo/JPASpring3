package com.softtek.jpa.services;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.softtek.jpa.domain.Status;

@RunWith(MockitoJUnitRunner.class)
public class StatusServiceImplTest {
	
	@Mock
	StatusService statusService;
	
	
	@Test
	public void testStatusServiceNotNull()
	{

		Assert.assertNotNull(statusService);
	}
	
	
	@Test
	public void testStatusServiceStatusListUsed(){
		List<Status>status=statusService.statusList("");
		verify(statusService).statusList("");
	}
	
	
	
	@Test
	public void testStatusServiceListStatusSizeOne(){
		Status status=new Status(1l, "Description", "Type");
		List<Status>listStatus=new ArrayList<Status>();
		listStatus.add(status);
		when(statusService.statusList(Matchers.anyString())).thenReturn(listStatus);
		List<Status> statusl=statusService.statusList("S");
		System.out.println(statusl);
		Assert.assertTrue(statusl.size()==1);
	}
	@Test
	public void testStatusServiceListReturnDescription(){
		Status status=new Status(1l, "Description", "Type");
		List<Status>listStatus=new ArrayList<Status>();
		listStatus.add(status);
		when(statusService.statusList(Matchers.anyString())).thenReturn(listStatus);
		List<Status> statusl=statusService.statusList("S");
		Status stat=statusl.get(0);
		Assert.assertTrue(stat.getType().equals("Type"));
	}
}
	
	



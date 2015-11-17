package com.learnback.work;

import java.rmi.RemoteException;

import org.apache.axis2.AxisFault;
import org.junit.Test;

import com.learnback.work.webservice.client.WebServiceStub;
import com.learnback.work.webservice.client.WebServiceStub.FindResponse;
import com.learnback.work.webservice.client.WebServiceStub.FindResponseResponse;
import com.learnback.work.webservice.client.WebServiceStub.MTResponse;
import com.learnback.work.webservice.client.WebServiceStub.PostSingle;
import com.learnback.work.webservice.client.WebServiceStub.PostSingleResponse;

public class WebServiceTest {

	@Test
	public void postSingle() {
		// TODO Auto-generated method stub
		try {
			WebServiceStub stub = new WebServiceStub();
			PostSingle postSingle = new PostSingle();
			postSingle.setAccount("user01@ent01");
			postSingle.setPassword("123456");
			postSingle.setMobile("18287131062");
			postSingle.setContent("axis web client 测试");
			postSingle.setSubid("123");
			PostSingleResponse response = stub.postSingle(postSingle);
			System.out.println(response.getPostSingleResult());
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Test
	public void findResponse() {
		// TODO Auto-generated method stub
		try {
			WebServiceStub stub = new WebServiceStub();
			FindResponse findResponse = new FindResponse();
			findResponse.setAccount("user01@ent01");
			findResponse.setPassword("123456");
			findResponse.setMobile("18287131062");
			findResponse.setBatchid("1d2457f2-5636-4fde-86bf-762775dc21fd");
			findResponse.setPageindex(1);
			findResponse.setFlag(1);
			FindResponseResponse response = stub.findResponse(findResponse);
			MTResponse[] mtResponses = response.getFindResponseResult()
					.getMTResponse();
			for (MTResponse mtResponse : mtResponses) {
				System.out.println(mtResponse.getReserve());
			}
		} catch (AxisFault e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}

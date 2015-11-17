package com.learnback.work.entity;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.esms.PostMsg;

@Component
public class PostServer implements InitializingBean{

	@Value("${mtHost}")
	private String mtHost;
	@Value("${mtPort}")
	private int mtPort;
	@Value("${moHost}")
	private String moHost;
	@Value("${moPort}")
	private int moPort;
	@Value("${username}")
	private String username;
	@Value("${password}")
	private String password;
	private PostMsg postMsg;

	public PostServer() {
		postMsg = new PostMsg();
	}

	public String getMtHost() {
		return mtHost;
	}

	public void setMtHost(String mtHost) {
		this.mtHost = mtHost;
	}

	public int getMtPort() {
		return mtPort;
	}

	public void setMtPort(int mtPort) {
		this.mtPort = mtPort;
	}

	public String getMoHost() {
		return moHost;
	}

	public void setMoHost(String moHost) {
		this.moHost = moHost;
	}

	public int getMoPort() {
		return moPort;
	}

	public void setMoPort(int moPort) {
		this.moPort = moPort;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public PostMsg getPostMsg() {
		return postMsg;
	}

	public void setPostMsg(PostMsg postMsg) {
		this.postMsg = postMsg;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		postMsg.getCmHost().setHost(mtHost, mtPort);
		postMsg.getWsHost().setHost(moHost, moPort);
	}

}

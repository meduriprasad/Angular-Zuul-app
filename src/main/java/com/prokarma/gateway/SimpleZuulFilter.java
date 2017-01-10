package com.prokarma.gateway;

import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class SimpleZuulFilter extends ZuulFilter {

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		ctx.addZuulRequestHeader("Content-type", "application/json");
		return null;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public int filterOrder() {
		return 1;
	}

	@Override
	public String filterType() {
		return "pre";
	}

}

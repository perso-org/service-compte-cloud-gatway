package com.tfa.config;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoutesConfiguration {

	private static final String dateTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH-mm"));

	@Bean
	public RouteLocator configRoutes(RouteLocatorBuilder builder) {

		return builder.routes()
				.route(p -> p.path("/tfanny/comptes/**")
						.filters(w -> w.rewritePath("/tfanny/comptes/(?<portion>.*)", "/${portion}")
								.addRequestHeader("X-Response-Time", dateTime))
						.uri("lb://COMPTES"))

				.route(p -> p.path("/tfanny/cartes/**")
						.filters(w -> w.rewritePath("/tfanny/cartes/(?<portion>.*)", "/${portion}")
								.addRequestHeader("X-Response-Time", dateTime))
						.uri("lb://CARTES"))

				.route(p -> p.path("/tfanny/emprunts/**")
						.filters(w -> w.rewritePath("/tfanny/emprunts/(?<portion>.*)", "/${portion}")
								.addRequestHeader("X-Response-Time", dateTime))
						.uri("lb://EMPRUNTS"))
				.build();
	}
}

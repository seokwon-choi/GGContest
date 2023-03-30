package digico.com.GGcontestb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.PageableHandlerMethodArgumentResolverCustomizer;
import org.springframework.data.web.config.SortHandlerMethodArgumentResolverCustomizer;

@Configuration
public class PageableConfig {
  @Bean
	public PageableHandlerMethodArgumentResolverCustomizer customize() {
		return p -> {
			p.setOneIndexedParameters(true);
			p.setMaxPageSize(15);
		};
	}

	@Bean
	public SortHandlerMethodArgumentResolverCustomizer sort(){
		return p ->{ 
			p.setFallbackSort(Sort.by("cretDt").descending());
		};
	}
}
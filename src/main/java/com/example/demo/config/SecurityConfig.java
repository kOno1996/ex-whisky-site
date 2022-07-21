package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	// セキュリティの対象外を設定
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/css/**", "addInterlocking.js", "/img/**");
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		//super.configure(http);
		//webアプリケーションが管理しているリソースへのアクセス制御の設定をするためのメソッド		
		//認証方式：httpBasic: 				
		http.authorizeRequests()
		//cssも含めてユーザ認証済みであることが条件となっているのでログイペ―ジが表示されたときにcssが適応されない問題がでる：antMatchersでcssは認証なしでも表示できるよう許可している
		.antMatchers("/mypage/**").permitAll()
		.antMatchers("/signin").permitAll()
		.antMatchers("/whisky").permitAll()
		//.antMatchers("/buy/mail").permitAll()
		.and().authorizeRequests().antMatchers("/buy/**").hasRole("USER")
		.and().authorizeRequests().antMatchers("/edit/**").hasRole("ADMIN")
		
		//anyRequest, authenticated(全てのリクエストに対して認証済みであることを要求している)=>ログインしていないとこのwebアプリケーション配下のリソースにはアクセスできないという設定をしている
		.anyRequest().authenticated();
		
		http
		.formLogin().loginProcessingUrl("/login").loginPage("/signin")
		//ログインページでユーザは認証されていない状態なのでpermitAllメソッドで全ての認証を許可している
		.usernameParameter("name").passwordParameter("password").permitAll()
		.defaultSuccessUrl("/product-list", true)
		.and().logout().logoutSuccessUrl("/signin")
		.invalidateHttpSession(true)
		//クッキーを削除する
		.deleteCookies("JSESSIONID");
		
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		// ユーザ認証の際のパスワードをハッシュ化して保存する設定
		// 実際の現場だと組み込みのクラスを使うとロジックが分かってしまうため、パスワードエンコーダーはプロジェクト独自のものを利用した方がよい(ストレッチングなど)
		// ストレッチング(ハッシュ化された文字列をさらにハッシュ化する)
		return new BCryptPasswordEncoder();
	}
}

//package com.workemail.config;
//
//import java.io.IOException;
//
//import javax.sql.DataSource;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import com.amazonaws.auth.AWSStaticCredentialsProvider;
//import com.amazonaws.auth.BasicAWSCredentials;
//import com.amazonaws.services.secretsmanager.AWSSecretsManager;
//import com.amazonaws.services.secretsmanager.AWSSecretsManagerClientBuilder;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueRequest;
//import com.amazonaws.services.secretsmanager.model.GetSecretValueResult;
//import com.google.gson.Gson;
//import com.zaxxer.hikari.HikariConfig;
//import com.zaxxer.hikari.HikariDataSource;
//
////@EnableConfigurationProperties(AwsSecretsManagerProperties.class)
////@ConditionalOnClass({ AWSSecretsManager.class })
////@ConditionalOnProperty(prefix = AwsSecretsManagerProperties.CONFIG_PREFIX, name = "enabled", matchIfMissing = true)
//@Configuration
//public class ApplicationConfig {
//
//	@Value("${cloud.aws.credentials.access-key}")
//	private String accessKey;
//
//	@Value("${cloud.aws.credentials.secret-key}")
//	private String secretKey;
//
//	private Gson gson = new Gson();
//
//	@Bean
//	public DataSource getDataSource1() throws IOException {
//
//		AwsSecrets awsSecrets = getSecret();
//		HikariConfig hikariConfig = new HikariConfig();
//		hikariConfig.setUsername(awsSecrets.getUsername());
//		hikariConfig.setPassword(awsSecrets.getPassword());
//		hikariConfig.setDriverClassName("com.mysql.cj.jdbc.Driver");
//		hikariConfig.setJdbcUrl("jdbc:" + awsSecrets.getEngine() + "://" + awsSecrets.getHost() + ":"
//				+ awsSecrets.getPort() + "/layover");
//		hikariConfig.addDataSourceProperty(accessKey, hikariConfig);
//		HikariDataSource hikariDataSource = new HikariDataSource(hikariConfig);
//		System.out.println(hikariDataSource + "-------------------");
//		return hikariDataSource;
//	}
//
//	@Bean
//	public DataSource getDataSo1() {
//
//		return null;
//
//	}
//
//	@SuppressWarnings("null")
//	public AwsSecrets getSecret() {
//		String secretName = "layover-RDS-mysql";
//		String region = "eu-central-1";
//
//		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region)
//				.withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials(accessKey, secretKey)))
//				.build();
//
////		System.out.println(build);
//
////		AWSSecretsManager client = AWSSecretsManagerClientBuilder.standard().withRegion(region).build();
//
//		String secret;
//		GetSecretValueRequest getSecretValueRequest = new GetSecretValueRequest().withSecretId(secretName);
//		GetSecretValueResult getSecretValueResult = null;
//		System.out.println(client);
//		System.out.println(getSecretValueRequest.getSecretId() + " getSecretValueRequest");
//		System.out.println(client.getSecretValue(getSecretValueRequest));
//		try {
//			getSecretValueResult = client.getSecretValue(getSecretValueRequest);
//			System.out.println(getSecretValueResult);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		System.out.println(getSecretValueResult.getSecretString() + " ");
//		if (getSecretValueResult != null && getSecretValueResult.getSecretString() != null) {
//			secret = getSecretValueResult.getSecretString();
//			return gson.fromJson(secret, AwsSecrets.class);
//		} else {
//			return null;
//		}
//
//	}
//
//}
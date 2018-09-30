package com.mute.webapp.firstWebApp.batch;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.JobScope;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.FlatFileItemWriter;
import org.springframework.batch.item.file.builder.FlatFileItemReaderBuilder;
import org.springframework.batch.item.file.builder.FlatFileItemWriterBuilder;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.transform.PassThroughLineAggregator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

@Configuration
@EnableBatchProcessing
public class TestJobConfiguration {
	 @Autowired
	    private JobBuilderFactory jobBuilderFactory;
	 
	    @Autowired
	    private StepBuilderFactory stepBuilderFactory;
	    
	    //test job def
	    @Bean
	    public Job jobOne() {
	        return jobBuilderFactory.get("testJob")
	                .incrementer(new RunIdIncrementer())
	                .start(step1())
	                .build();
	    }
	
	    @Bean
	    public FlatFileItemReader<BatchBO> myTxtReader() {
	        return new FlatFileItemReaderBuilder<BatchBO>()
	            .name("personItemReader")
	            .resource(new ClassPathResource("sample-data.csv"))
	            .delimited()
	            .names(new String[]{"ColumnA", "ColumnB"})
	            .fieldSetMapper(new BeanWrapperFieldSetMapper<BatchBO>() {{
	                setTargetType(BatchBO.class);
	            }})
	            .build();
	    }
	    
	    
	    
	    @Bean
	    public FlatFileItemWriter myTxtWriter() {
	            return  new FlatFileItemWriterBuilder<BatchBO>()
	                                       .name("itemWriter")
	                                       .resource(new FileSystemResource("\\target\\classes\\output.txt"))
	                                       .lineAggregator(new PassThroughLineAggregator<>())
	                                       .build();
	    }

	 
	    //step
	    @Bean
	    @JobScope
	    public Step step1() {
	        return stepBuilderFactory.get("step1")
	                .<BatchBO,BatchBO>chunk(10)
	                .reader(myTxtReader())
	                .processor(new TestProcesser())
	                .writer(myTxtWriter())
	                .build();
	    }

}

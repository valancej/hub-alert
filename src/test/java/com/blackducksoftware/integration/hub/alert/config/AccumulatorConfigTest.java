package com.blackducksoftware.integration.hub.alert.config;

import org.mockito.Mockito;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.SimpleJobLauncher;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.transaction.PlatformTransactionManager;

import com.blackducksoftware.integration.hub.alert.accumulator.AccumulatorProcessor;
import com.blackducksoftware.integration.hub.alert.accumulator.AccumulatorReader;
import com.blackducksoftware.integration.hub.alert.accumulator.AccumulatorWriter;

public class AccumulatorConfigTest extends CommonConfigTest<AccumulatorReader, AccumulatorWriter, AccumulatorProcessor, AccumulatorConfig> {

    @Override
    public String getJobName() {
        return "AccumulatorJob";
    }

    @Override
    public String getStepName() {
        return "AccumulatorStep";
    }

    @Override
    public AccumulatorConfig getConfigWithNullParams() {
        return new AccumulatorConfig(null, null, null, null, null, null, null, null, null);
    }

    @Override
    public AccumulatorConfig getConfigWithSimpleJobLauncher(final SimpleJobLauncher simpleJobLauncher) {
        return new AccumulatorConfig(simpleJobLauncher, null, null, null, null, null, null, null, null);
    }

    @Override
    public AccumulatorConfig getConfigWithTaskScheduler(final TaskScheduler taskScheduler) {
        return new AccumulatorConfig(null, null, null, null, null, null, null, taskScheduler, null);
    }

    @Override
    public AccumulatorConfig getConfigWithParams(final StepBuilderFactory stepBuilderFactory, final TaskExecutor taskExecutor, final PlatformTransactionManager platformTransactionManager) {
        return new AccumulatorConfig(null, null, stepBuilderFactory, taskExecutor, null, platformTransactionManager, null, null, null);
    }

    @Override
    public AccumulatorReader getMockReader() {
        return Mockito.mock(AccumulatorReader.class);
    }

    @Override
    public AccumulatorProcessor getMockProcessor() {
        return Mockito.mock(AccumulatorProcessor.class);
    }

    @Override
    public AccumulatorWriter getMockWriter() {
        return Mockito.mock(AccumulatorWriter.class);
    }

}

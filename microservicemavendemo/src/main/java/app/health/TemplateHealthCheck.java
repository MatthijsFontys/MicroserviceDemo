package app.health;

import com.codahale.metrics.health.HealthCheck;

public class TemplateHealthCheck extends HealthCheck {
    private final String template;

    public TemplateHealthCheck(String template) {
        this.template = template;
    }

    @Override
    protected Result check() throws Exception {
        final String message = String.format(template, "TEST");
        Result result = Result.healthy();
        if(!message.contains("TEST")){
            result = Result.unhealthy("template does not include a name!");
        }
        return result;
    }
}

package com.example.onlinestore;

import com.example.onlinestore.model.Promotion;
import com.example.onlinestore.model.PromotionCode;
import com.example.onlinestore.repository.PromotionRepository;
import com.github.javafaker.Faker;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.toList;

@Component
@ConditionalOnProperty(name = "app.db-init", havingValue = "true")
@Slf4j
public class DataLoader {


    public static final int NR_OF_PROMOTIONS = 1000;


    @Autowired
    private PromotionRepository promotionRepository;

    @PostConstruct
    public void init() {
        Faker faker = new Faker();

        // 1.000.000 records/, 8s to create objects, 37s to save them
        // 10.000.000 records/, 1m30s to create objects, 6m10s seconds to save them
        // database size is 969 MB
        //
        // first query 135ms , second one 80ms
        // first count query 600ms

        createPromotions(faker);

    }

    private void createPromotions(Faker faker) {
        log.info("Creating promotions");
        List<Promotion> promotions = IntStream
                .range(0, NR_OF_PROMOTIONS)
                .mapToObj(i ->
                {
                    Date fromDate = faker.date().past(faker.random().nextInt(1, 30), TimeUnit.DAYS);
                    Date toDate =  Date.from(fromDate.toInstant().plus(3, ChronoUnit.DAYS));
                    return Promotion
                            .builder()
                            .withName("Promotion " + i)
                            .withFromDate(fromDate)
                            .withToDate(faker.date().past(faker.random().nextInt(1, 30), TimeUnit.DAYS))
                            .withPromotionCode(PromotionCode.getRandomPromotionCode())
                            .build();
                })
                .collect(toList());
        log.info("Created promotions");
        log.info("Saving promotions");
        promotionRepository.saveAll(promotions);
        log.info("Saved  promotions");
    }

}

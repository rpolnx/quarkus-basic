package br.com.rpolnx.quarkus_basics.model.dto.dota2;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import java.util.List;

@Data
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StatusDTO {
    private Integer userPlayers;
    private Integer trackedPlayers;
    private Integer matchesLastDay;
    private Integer matchesLastHour;
    private Integer retrieverMatchesLastDay;
    private Integer retrieverPlayersLastDay;
    private Integer backupRetrieverLastDay;
    private Integer parsedMatchesLastDay;
    private Integer requestsLastDay;
    private Integer fullhistoryLastDay;
    private Integer webhooksLastDay;
    private Integer feedLastDay;
    private Integer apiHitsLastDay;
    private Integer apiHitsUiLastDay;
    @JsonProperty("fhQueue")
    private Integer fhQueue;
    @JsonProperty("gcQueue")
    private Integer gcQueue;
    @JsonProperty("mmrQueue")
    private Integer mmrQueue;
    @JsonProperty("countsQueue")
    private Integer countsQueue;
    @JsonProperty("scenariosQueue")
    private Integer scenariosQueue;
    @JsonProperty("benchmarksQueue")
    private Integer benchmarksQueue;
    private List<Retriever> retriever;
    private List<ApiPath> apiPaths;
    private List<LastAdded> last_added;
    private List<LastParsed> lastParsed;
    private LoadTimes loadTimes;
    private Health health;

    @Data
    public static class Retriever {
        private String hostname;
        private String count;
    }

    @Data
    public static class ApiPath {
        private String hostname;
        private String count;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class LastAdded {
        private Long matchId;
        private Integer duration;
        private Integer startTime;
    }

    @Data
    @JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
    public static class LastParsed {
        private Long matchId;
        private Integer duration;
        private Integer startTime;
    }

    @Data
    public static class LoadTimes {
        @JsonProperty("50")
        private Integer _50;
        @JsonProperty("75")
        private Integer _75;
        @JsonProperty("90")
        private Integer _90;
        @JsonProperty("95")
        private Integer _95;
        @JsonProperty("99")
        private Integer _99;
    }

    @Data
    public static class Health {
        private CassandraUsage cassandraUsage;
        private GcDelay gcDelay;
        private RedisUsage redisUsage;
        private PostgresUsage postgresUsage;
        private SeqNumDelay seqNumDelay;
        private ParseDelay parseDelay;
        private SteamApi steamApi;

        @Data
        public static class CassandraUsage {
            private double metric;
            private long threshold;
            private Integer timestamp;
        }

        @Data
        public static class GcDelay {
            private Integer metric;
            private Integer threshold;
            private Integer timestamp;
        }

        @Data
        public static class RedisUsage {
            private Integer metric;
            private long threshold;
            private Integer timestamp;
        }

        @Data
        public static class PostgresUsage {
            private long metric;
            private long threshold;
            private Integer timestamp;
        }

        @Data
        public static class SeqNumDelay {
            private Integer metric;
            private Integer threshold;
            private Integer timestamp;
        }

        @Data
        public static class ParseDelay {
            private Integer metric;
            private Integer threshold;
            private Integer timestamp;
        }

        @Data
        public static class SteamApi {
            private Integer metric;
            private Integer threshold;
            private Integer timestamp;
        }
    }
}


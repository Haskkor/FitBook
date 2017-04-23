DROP TABLE public.workout_workout_exercise;

CREATE TABLE public.workout_workout_exercise
(
    workout_id bigint NOT NULL,
    workout_exercise_id bigint NOT NULL,
    CONSTRAINT workout_workout_exercise_pkey PRIMARY KEY (workout_id, workout_exercise_id),
    CONSTRAINT workout_exercise_fkey FOREIGN KEY (workout_exercise_id)
        REFERENCES public.workout_exercise (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT workout_fkey FOREIGN KEY (workout_id)
        REFERENCES public.workout (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.workout_workout_exercise
    OWNER to postgres;
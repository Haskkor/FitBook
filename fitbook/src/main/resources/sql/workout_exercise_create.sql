DROP TABLE public.workout_exercise;

CREATE TABLE public.workout_exercise
(
    id SERIAL NOT NULL,
    sets_reps character varying(30) COLLATE pg_catalog."default" NOT NULL,
    weights character varying(30) COLLATE pg_catalog."default" NOT NULL,
    exercise_id integer NOT NULL,
    CONSTRAINT workout_exercise_pkey PRIMARY KEY (id),
    CONSTRAINT workout_exercise_exercise_id_fkey FOREIGN KEY (exercise_id)
        REFERENCES public.exercise (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.workout_exercise
    OWNER to postgres;
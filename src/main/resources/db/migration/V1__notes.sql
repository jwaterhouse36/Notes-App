CREATE TABLE IF NOT EXISTS public.notes
(
    id integer NOT NULL GENERATED ALWAYS AS IDENTITY ( INCREMENT 1 START 1 ),
    title character varying(255) NOT NULL,
    body character varying(255) NOT NULL,
    date date NOT NULL,
    PRIMARY KEY (id)
);
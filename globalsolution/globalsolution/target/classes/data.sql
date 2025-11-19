-- Este arquivo (data.sql) é executado automaticamente pelo Spring Boot
-- para popular o banco de dados (H2) com dados iniciais (seeds).

-- 1. Inserindo dados na tabela 'trilhas'
-- (id, nome, descricao, nivel, carga_horaria, foco_principal)
INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal)
VALUES (
           'IA para Não-Programadores',
           'Aprenda como a Inteligência Artificial está mudando o mercado e como usá-la no dia-a-dia.',
           'INICIANTE',
           40,
           'IA e Automação'
       );

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal)
VALUES (
           'Desenvolvedor de Soluções com IA (GenAI)',
           'Foco em APIs de GenAI e como construir aplicações que pensam.',
           'AVANCADO',
           120,
           'Desenvolvimento e IA'
       );

INSERT INTO trilhas (nome, descricao, nivel, carga_horaria, foco_principal)
VALUES (
           'Liderança Híbrida e Habilidades Humanas',
           'Como liderar equipes remotas com empatia, criatividade e colaboração.',
           'INTERMEDIARIO',
           60,
           'Soft Skills e Liderança'
       );


-- 2. Inserindo dados na tabela 'usuarios'
-- (id, nome, email, area_atuacao, nivel_carreira, data_cadastro)
INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES (
           'Ana Silva',
           'ana.silva@email.com',
           'Recursos Humanos',
           'JUNIOR',
           '2025-01-10'
       );

INSERT INTO usuarios (nome, email, area_atuacao, nivel_carreira, data_cadastro)
VALUES (
           'Bruno Costa',
           'bruno.costa@email.com',
           'Marketing Digital',
           'PLENO',
           '2025-02-15'
       );
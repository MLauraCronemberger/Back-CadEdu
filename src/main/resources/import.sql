 -- import.sql
INSERT INTO informacoes_series (serie, id, nivel_ensino, turma, turno) VALUES
(1, 1, 'Ensino Fundamental', 'A', 'Manhã'),
(3, 2, 'Ensino Médio', 'B', 'Tarde'),
(4, 3, 'Ensino Fundamental', 'C', 'Noite');

INSERT INTO informacoes_disciplinas (disc, ch, id_serie) VALUES
('Matemática', '80', 1),  
('Português', '60', 2), 
('História', '70', 3);  

INSERT INTO informacoes_docentes (nome, cpf, datnasc, tel, email, cargo, id_disciplina) VALUES
('João Silva', '123.456.789-00', '1980-02-15', '123456789', 'joao.silva@mail.com', 'Professor', 1),  
('Maria Souza', '987.654.321-00', '1975-03-10', '987654321', 'maria.souza@mail.com', 'Professor', 2),
('Carlos Oliveira', '456.789.123-00', '1985-07-20', '456789123', 'carlos.oliveira@mail.com', 'Professor', 3);  

INSERT INTO informacoes_aluno (nome, cpf, datnasc, responsavel, foto, nivel_ensino, id_serie) VALUES
('Pedro Lima', '112.233.445-66', '2005-11-05', 'Lucia Lima', 'foto_pedro.jpg', 'Ensino Fundamental', 1),  
('Ana Costa', '998.877.665-44', '2004-09-10', 'Roberta Costa', 'foto_ana.jpg', 'Ensino Médio', 2),  
('Lucas Pereira', '223.344.556-77', '2003-12-22', 'Fernanda Pereira', 'foto_lucas.jpg', 'Ensino Fundamental', 3);  

INSERT INTO docentes_serie (docente_id, serie_id) VALUES
(1, 1),  
(2, 2), 
(3, 3);

  {
    "serie": 1,
    "nivelEnsino": "Ensino Fundamental",
    "turma": "C",
    "turno": "Manhã"
  }
  
  {
  "disc": "Matemática",
  "ch": 80,
  "serie": { "id": 2 }
}
  
  
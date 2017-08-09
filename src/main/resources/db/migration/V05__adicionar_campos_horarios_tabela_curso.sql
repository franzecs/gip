ALTER TABLE curso 
ADD COLUMN `horarioseg` VARCHAR(32) NULL AFTER `ies`,
ADD COLUMN `horarioter` VARCHAR(32) NULL AFTER `horarioseg`,
ADD COLUMN `horarioqua` VARCHAR(32) NULL AFTER `horarioter`,
ADD COLUMN `horarioqui` VARCHAR(32) NULL AFTER `horarioqua`,
ADD COLUMN `horariosex` VARCHAR(32) NULL AFTER `horarioqui`;

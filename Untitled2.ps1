<#
setup_lab.ps1
Crea un entorno de laboratorio simple con archivos de prueba y copia de seguridad.
#>


$LabRoot = "C:\LabAtaqueSencillo"
$Target = Join-Path $LabRoot "servidores\datos"
$Backup = Join-Path $LabRoot "backup"


# Crear estructura
New-Item -Path $Target -ItemType Directory -Force | Out-Null
New-Item -Path $Backup -ItemType Directory -Force | Out-Null


# Crear archivos de prueba
1..3 | ForEach-Object {
$f = Join-Path $Target ("informe_prueba_{0}.txt" -f $_)
"Fichero de prueba $_`nContenido SIMULADO para el laboratorio." | Out-File -FilePath $f -Encoding UTF8
}


# Hacer copia de seguridad
Copy-Item -Path (Join-Path $Target "*") -Destination $Backup -Recurse -Force


Write-Host "Laboratorio creado en: $LabRoot"
Write-Host "Revisa: $Target"

#############


$LabRoot = "C:\LabAtaqueSencillo"
$Target = Join-Path $LabRoot "servidores\datos"
$Log = Join-Path $LabRoot "logs"
$Device = Join-Path $LabRoot "dispositivo_simulado"


# Comprobación
if (-not (Test-Path $Target)) { Write-Error "Ejecuta primero setup_lab.ps1"; exit 1 }


# Preparar logs y "dispositivo"
New-Item -Path $Log -ItemType Directory -Force | Out-Null
New-Item -Path $Device -ItemType Directory -Force | Out-Null


# 1) Registrar acceso físico simulado
$time = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
"$time - Acceso físico simulado: persona entra y conecta un dispositivo." | Out-File -FilePath (Join-Path $Log "physical_access.txt") -Encoding UTF8 -Append


# 2) Simular dispositivo (marcador)
"DISPOSITIVO_SIMULADO" | Out-File -FilePath (Join-Path $Device "marker.txt") -Encoding UTF8


# 3) Registrar metadatos y "marcar" archivos (renombrado seguro)
"timestamp,filename,bytes" | Out-File -FilePath (Join-Path $Log "metadata.csv") -Encoding UTF8
Get-ChildItem -Path $Target -File | ForEach-Object {
$ts = Get-Date -Format "yyyy-MM-dd HH:mm:ss"
"$ts,$($_.Name),$($_.Length)" | Out-File -FilePath (Join-Path $Log "metadata.csv") -Encoding UTF8 -Append


# Renombrar para simular bloqueo (no cifra)
$new = $_.FullName + ".SIMULATED_LOCK"
Rename-Item -Path $_.FullName -NewName $new -ErrorAction SilentlyContinue
}


# 4) Nota de simulación
"ATENCIÓN: esto es una simulación de laboratorio. NO pagar rescate." | Out-File -FilePath (Join-Path $Target "NOTICE_SIMULATION.txt") -Encoding UTF8


Write-Host "Simulación completada. Revisa logs en: $Log"

#############


$LabRoot = "C:\LabAtaqueSencillo"
$Target = Join-Path $LabRoot "servidores\datos"
$Backup = Join-Path $LabRoot "backup"


if (-not (Test-Path $Backup)) { Write-Error "No existe backup. Ejecuta setup_lab.ps1 antes."; exit 1 }


# Restaurar contenido
Copy-Item -Path (Join-Path $Backup "*") -Destination $Target -Recurse -Force


# Eliminar archivos .SIMULATED_LOCK residuales
Get-ChildItem -Path $Target -Recurse -File | Where-Object { $_.Name -like "*.SIMULATED_LOCK" } | ForEach-Object { Remove-Item $_.FullName -Force -ErrorAction SilentlyContinue }


# Eliminar nota de simulación
$notice = Join-Path $Target "NOTICE_SIMULATION.txt"
if (Test-Path $notice) { Remove-Item $notice -Force -ErrorAction SilentlyContinue }


Write-Host "Restauración completada. Verifica $Target"
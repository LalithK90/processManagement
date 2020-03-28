package lk.customs.processManagement.asset.commonAsset.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FileInfo {
    private String filename;
    private LocalDateTime createAt;
    private String url;
}


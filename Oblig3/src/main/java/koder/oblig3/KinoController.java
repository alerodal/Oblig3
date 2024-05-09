package koder.oblig3;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class KinoController {

    @Autowired
    KinoRepository rep;

    @PostMapping("/lagreBilletter")
    public void setKinoBilletter(Kino kino) {
      rep.lagreKino(kino);
    }

    @GetMapping("/hentBilletter")
    public List<Kino> getKinoBilletter() {
      return rep.hentKino();
    }

    @GetMapping("/slett")
    public void slettBillett() {
        rep.slettKino();
    }

}

